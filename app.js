const express = require('express');
const app = express();

const mongoose = require('mongoose');

mongoose.connect('mongodb://localhost/projeto').then(() => {
    console.log("Conexão com o banco estabelecida com sucesso!")
}).catch(error => {
    console.log("Conexão não estabelecida!!!")
});

app.use(express.json);

app.get("/", (req, res) => {
    return res.json({
        título: "Teste API REST - Aula Sistemas Distribuídos"
    });
});

app.listen(8080, () => {
    console.log("Servidor iniciado na porta 8080!");
});

