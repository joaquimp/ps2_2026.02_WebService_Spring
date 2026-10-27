async function listar() { 
    let dados = await fetch("http://localhost:8080/pets");
    let json = await dados.json();
    console.table(json);
}

await listar();
// inserir
const novoPet = {id:0, nome: "Joca", idade:2000};
let dados = await fetch("http://localhost:8080/pets", {
    method: "POST",
    body: JSON.stringify(novoPet),
    headers: {
        "Content-Type": "application/json",
    },
});
let json = await dados.json();
console.table(json);
await listar();