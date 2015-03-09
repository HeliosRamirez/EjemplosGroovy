String original = "Hola Mundo todo bien"
String reemplazado = original

Integer ocurrencias = original.count("o")
ocurrencias.times {numero ->
    reemplazado = reemplazado.replaceFirst("o",{
        String x = ""
        (numero + 1).times {x += "x"}
        x
    })
}
println reemplazado
