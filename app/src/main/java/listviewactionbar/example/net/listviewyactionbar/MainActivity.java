package listviewactionbar.example.net.listviewyactionbar;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;

public class MainActivity extends ListActivity {

    private static final String[] items = {"En", "un", "lugar", "de",
            "la", "Mancha", "de", "cuyo", "nombre", "no", "quiero",
            "acordarme", "no", "ha", "mucho", "tiempo", "que",
            "vivía", "un", "hidalgo", "de", "los", "de", "lanza",
            "en", "astillero", "adarga", "antigua", "rocín", "flaco",
            "y", "galgo", "corredor"};
    private ArrayAdapter<String> adaptador;
    private ListView lista ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        adaptador = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1,primerasLetras());
        lista = new ListView();
        lista.setAdapter(adaptador);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.anyadir:
                añadirCadena(items[adaptador.getCount()-1]);
                break;
            case R.id.reset:
                primerasLetras();
                break;
            case R.id.acercade:
                Toast.makeText(this, "Estamos introduciendo palabras al arrayAdapter"
                        ,Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }

    public ArrayList<String> primerasLetras(){
        ArrayList<String> primerasSeis = new ArrayList<String>();
        for(int i=0;i<6;i++){
            primerasSeis.add(i, items[i]);
        }

        return primerasSeis;
    }

    public void añadirCadena(String cadena){
        adaptador.add(cadena);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return(super.onCreateOptionsMenu(menu));
    }
}
