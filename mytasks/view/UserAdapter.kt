package com.example.mytasks.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.mytasks.R
import com.example.mytasks.model.User

class UserAdapter : ListAdapter<User, UserAdapter.UserViewHolder>(UserDiffCallBack()) {
    // Este método é chamado para criar uma nova ViewHolder.
    // Ele "infla" (cria) a view do item a partir do XML.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserAdapter.UserViewHolder {
        // Cria a view a partir do layout item_user.xml.
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false )
        return UserViewHolder(view)
    }

    //Este metodo é chamado para vincular os dados de um item à sua view
    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        //pega o item da lista na posição atual
        val user = getItem(position)
        //Chama o metodo bind do ViewHolder para configurar a view com os dados do usuário.
        holder.bind(user)
    }
    // ViewHolder é uma classe interna que armazena as referências das views de um item.
    // Isso evita chamadas repetidas a findViewById(), melhorando a performance.
    class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        // Referências para as views dentro do item_user.xml.
        private val tvName: TextView = itemView.findViewById(R.id.tvName)
        private val ivAvatar: ImageView = itemView.findViewById(R.id.ivAvatar)

        //Método para vincular os dados do objeto User às views
        fun bind(user: User){
            tvName.text = user.name
            // Em um app real, você usaria uma biblioteca como Glide ou Coil para carregar a imagem da URL.
            // Ex: Glide.with(itemView.context).load(user.avatarUrl).into(ivAvatar)
            // Para simplificar, vamos apenas usar um placeholder.
            ivAvatar.setImageResource(R.mipmap.ic_launcher_round)
        }
    }
}