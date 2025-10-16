import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mytasks.R
import com.example.mytasks.model.User
import com.example.mytasks.view.UserAdapter

class MainActivity : AppCompatActivity() {

    // Declaração tardia do adapter. Ele será inicializado em onCreate.
    private lateinit var userAdapter: UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Encontra o RecyclerView no layout.
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)

        // Instancia o nosso adapter.
        userAdapter = UserAdapter()

        // Configura o RecyclerView.
        recyclerView.apply {
            // Define o LayoutManager, que posiciona os itens (vertical, horizontal, grid).
            layoutManager = LinearLayoutManager(this@MainActivity)
            // Define o adapter para o RecyclerView.
            adapter = userAdapter
        }

        // Cria uma lista inicial de usuários.
        val initialUsers = listOf(
            User(1, "Ana", "url_avatar_1"),
            User(2, "Bruno", "url_avatar_2"),
            User(3, "Carlos", "url_avatar_3")
        )

        // Envia a lista inicial para o adapter.
        // O ListAdapter calculará as diferenças (nenhuma, neste caso) e exibirá a lista.
        userAdapter.submitList(initialUsers)

        // Exemplo de como atualizar a lista (ex: após 3 segundos).
        // Em um app real, isso viria de uma API, banco de dados, etc.
        recyclerView.postDelayed({
            val updatedUsers = listOf(
                User(1, "Ana Silva", "url_avatar_1"), // Conteúdo alterado
                User(3, "Carlos", "url_avatar_3"),    // Posição alterada
                User(4, "Daniela", "url_avatar_4")    // Novo item
                // O item com id 2 (Bruno) foi removido.
            )
            // Envia a nova lista. O ListAdapter e o DiffUtil farão todo o trabalho pesado!
            // Eles vão detectar as mudanças e animar apenas o que for necessário.
            userAdapter.submitList(updatedUsers)
        }, 3000)
    }
}