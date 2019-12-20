console.log("Mostrar mensaje");

console.log(process.pid);
console.log(process.cwd());

var unObjeto = new Object();
unObjeto.propiedadA = "Valor A";
unObjeto["propiedadB"] = "Valor B";

var unObj2 = {
    "propiedadA": "Valor A", // Formato JSON (JavasScript Onject Notation)
    propiedadB: "Valor B", // Sólo en JS permite sin comillas simples
    'propiedadC': "Valor C",
    "metodo": function(){ return "unObj2 : " +this.propiedadA},
    "array": [2, "x", true] // Un array en JS en como un ArrayList<Object> de Java
}

console.log(`Valor de A: ${unObjeto['propiedadA']},
            Valor de B:
            ${unObjeto.propiedadB}`);
// Funciones en JS son objetos
function fun1(parA, parB){
    return "Resultado fun1: " + parA + ", " + parB;
}            

// El ámbito de var es a nivel de función
// El ámbito de let es a nivel de bloque de {} (como en Java)
let fun2 = function(parA, parB){
    return `Resultado fun2: ${parA}, ${parB}}`;
}

var fun3 = Function("parA","parB","return `Resultado fun2: ${parA}, ${parB}}`")
// Desde EcmaScript 6, ES2015
var fun4 = (parA, parB) => { return `Resultado fun2: ${parA}, ${parB}}`};
var fun5 = (parA, parB) => "Resultado fun5: " + parA + ", " + parB;

console.log(fun1 ("Argumento A", "Argumento B"));
console.log(fun2 ("Argumento A", "Argumento B"));
console.log(fun3 ("Argumento A", "Argumento B"));
console.log(fun4 ("Argumento A", "Argumento B"));
console.log(fun5 ("Argumento A", "Argumento B"));