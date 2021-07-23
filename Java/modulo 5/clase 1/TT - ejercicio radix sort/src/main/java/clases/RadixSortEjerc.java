package clases;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class RadixSortEjerc {

    public static void radixSort(int[] arr)
    {
        String[] strArr = StringUtil.toStringArray(arr);
        StringUtil.lNormalize(strArr, '0');

        int largo = StringUtil.maxLength(strArr);

        for(int i = largo - 1; i >= 0; i --) {
            TreeMap<String, ArrayList<String>> sorted = new TreeMap<>();
            for(String str : strArr) {
                if(sorted.containsKey(String.valueOf(str.charAt(i)))) {
                    sorted.get(String.valueOf(str.charAt(i))).add(str);
                }
                else {
                    ArrayList<String> values = new ArrayList<>();
                    values.add(str);
                    sorted.put(String.valueOf(str.charAt(i)), values);
                }
            }

            int index = 0;
            for (Map.Entry<String, ArrayList<String>> entry : sorted.entrySet()) {
                for(int y = 0; y < entry.getValue().size(); y ++) {
                    strArr[index] = entry.getValue().get(y);
                    index ++;
                }
            }

        }

        int[] arrIntAux = StringUtil.toIntArray(strArr);
        for(int i = 0; i < arrIntAux.length; i ++) {
            arr[i] = arrIntAux[i];
        }

    }

    public static void main(String args[])
    {
        int arr[]={16223,898,13,906,235,23,9,1532,6388,2511,8};
        radixSort(arr);

        for(int i=0; i<arr.length;i++)
        {
            System.out.print(arr[i]+(i<arr.length-1?",":""));
        }
    }

}
