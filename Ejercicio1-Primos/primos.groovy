def inicio = System.currentTimeMillis()
def numeros = (1..100).step(2)
numeros.each {numero ->
    if(!numeros.any {it > 1 && numero % it == 0 && it != numero}){numero == 1 ? print("${numero + 1} ") : print("$numero ")}
}
println (System.currentTimeMillis() - inicio)