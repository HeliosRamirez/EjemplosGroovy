Integer arabigo = 1985
String romano = "MMDCCXLVI"

ArabigoaRomano(arabigo)
RomanoaArabigo(romano)

def ArabigoaRomano(Integer arabigo){
    mapaArabRom = [1:'I', 5:'V', 10:'X', 50:'L', 100:'C', 500:'D', 1000:'M']
    Integer digito
    Integer numero = arabigo
    Integer exponente = 3
    StringBuffer romano = new StringBuffer()

    while (numero > 0) {
        digito = (numero / 10**exponente)
        numero = numero % (10**exponente)
        if (digito != 0) {
            if (digito % 5 == 0) {
                romano.append(mapaArabRom.get((10**exponente) * 5))
            } else if (digito < 5) {
                if (digito % 4 == 0) {
                    romano.append(mapaArabRom.get(10**exponente))
                    romano.append(mapaArabRom.get((10**exponente) * 5))
                } else {
                    (digito).times { romano.append(mapaArabRom.get(10**exponente)) }
                }
            } else {
                if (digito % 9 == 0) {
                    romano.append(mapaArabRom.get(10**exponente))
                    romano.append(mapaArabRom.get(10**(exponente + 1)))
                } else {
                    romano.append(mapaArabRom.get((10**exponente) * 5))
                    (digito - 5).times { romano.append(mapaArabRom.get(10**exponente)) }
                }
            }
        }
        exponente--
    }

    println "$arabigo: $romano"
}

def RomanoaArabigo(String romano){
    if(romano.count("VV") || romano.count("LL") || romano.count("DD")){
        println "numero invalido"
        return
    }
    mapa = ['I':1, 'V':5, 'X':10, 'L':50, 'C':100, 'D':500, 'M':1000]
    Integer arabigo = 0
    Character previa
    romano.each {
        if (!previa) {
            arabigo += mapa[it]
            previa = it.charAt(0)
        } else {
            if (mapa[previa.toString()] < mapa[it]) {
                arabigo -= mapa[previa.toString()]
                arabigo += (mapa[it] - mapa[previa.toString()])
            } else {
                arabigo += mapa[it]
            }
            previa = it.charAt(0)
        }
    }
    println "$romano: $arabigo"
}