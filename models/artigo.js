import { mongoose } from "../app";

const Artigo = new mongoose.Schema({
    título: {
        type: String,
        required: true
    },
    conteudo: {
        type: String,
        required: true
    }
}, {
    timestamps: true
}
});