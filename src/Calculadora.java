import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;

import Objeto.ObejtoConversorContagem;
import Objeto.ObjetoConversorCovid;

public class Calculadora{
    private File directory = new File("");

    public Calculadora() {

    }

    public void calcular(){
        HashMap<String, Integer> covid = criarHashMapCovid();
        HashMap<String, Integer> contagem = criarHashMapContagem();

        somar(covid, contagem);
    }

    private void somar() {
        for()
    }

    private HashMap<String, Integer> criarHashMapCovid() {
        HashMap<String, Integer> hash = new HashMap<>();

        try {
            Files.lines(Paths.get(directory.getAbsolutePath() + "/src/baseDeDados/covid/baseCovidLimpo.csv"))
                .map(line -> line.split(";"))
                .map(col-> new ObjetoConversorCovid(null, col[0], Integer.parseInt(col[1]), null))
                .forEach(obj -> {hash.put(obj.getEstado(), obj.getCasosAcumulado());});
        } catch (Exception e) {}
        return hash;
    }

    private HashMap<String, Integer> criarHashMapContagem() {
        HashMap<String, Integer> hash = new HashMap<>();

        try {
            Files.lines(Paths.get(directory.getAbsolutePath() + "/src/baseDeDados/Contagem Populacional Brasil/Contagem Populacional limpa.csv"))
                .map(line -> line.split(";"))
                .map(col-> new ObejtoConversorContagem(col[0], Integer.parseInt(col[1])))
                .forEach(obj -> {hash.put(obj.getEstado(), obj.getQuantidade());});
        } catch (Exception e) {}
        return hash;
    }
}