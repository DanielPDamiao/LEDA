import java.util.ArrayList;

public class MergeSort {
    
    public ArrayList<Integer> MerSort(int[] array, int ini, int fim){
        ArrayList<Integer> listaResp = new ArrayList<>();
        if(ini == fim){
             listaResp.add(array[ini]);
        }
        else{
            int medio = (ini + fim)/2;
            ArrayList<Integer> lista1 = (ArrayList<Integer>) MerSort(array, ini, medio).clone();
            ArrayList<Integer> lista2 = (ArrayList<Integer>) MerSort(array, medio+1, fim).clone();
            listaResp = (ArrayList<Integer>) MerSortOrd(listaResp, lista1, lista2).clone();
        }
        return listaResp;
    }

    private ArrayList<Integer> MerSortOrd(ArrayList<Integer> listaResp, ArrayList<Integer> lista1, ArrayList<Integer> lista2){
        if(lista1.size() == 0 && lista2.size() == 0){
            return listaResp;
        }
        else if(lista1.size() == 0){
            listaResp.add(lista2.get(0));
            lista2.remove(0);
        }
        else if(lista2.size() == 0){
            listaResp.add(lista1.get(0));
            lista1.remove(0);
        }
        else{
            if(lista1.get(0) <= lista2.get(0)){
                listaResp.add(lista1.get(0));
                lista1.remove(0);
            }
            else{
                listaResp.add(lista2.get(0));
                lista2.remove(0);
            }
        }
        listaResp = (ArrayList<Integer>) MerSortOrd(listaResp, lista1, lista2).clone();
        return listaResp;
    }
}
