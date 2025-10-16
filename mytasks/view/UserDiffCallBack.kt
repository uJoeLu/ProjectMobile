package com.example.mytasks.view

import androidx.recyclerview.widget.DiffUtil
import com.example.mytasks.model.User

class UserDiffCallBack : DiffUtil.ItemCallback<User>() {
    // Este método verifica se dois itens representam o mesmo objeto.
    // Geralmente, comparamos os IDs únicos dos itens.
    override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem.id == newItem.id
    }
    // Este método verifica se o conteúdo de dois itens é o mesmo.
    // É chamado apenas se areItemsTheSame() retornar true.
    // O Kotlin data class gera o método equals() que compara todas as propriedades,
    // então podemos simplesmente usar '==' aqui.
    override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem == newItem
    }
}