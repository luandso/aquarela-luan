package br.senai.sp.jandira.mobile_aquarela.model

data class UsuarioCompleto(
    val id: Long = 0,
    val nome: String = "",
    val nome_usuario: String = "",
    val foto_usuario: String? = "",
    val descricao: String? = "",
    val email: String = "",
    val senha: String = "",
    val cpf: String = "",
    val data_nascimento: String = "",
    val telefone: String = "",
    val disponibilidade: Boolean?,
    val user_stats: Boolean = true
)
