import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class inter {

    public static int[] cells = new int[200];
    public static int register = -1;
    public static int lvl = 0;
    public static int index = 0;
    public static int ind = 0;
    public static int i = 0;

    static void switching(Object item, Object[] arr) {
        switch (item.toString()) {
            case "MoO":
                cells[index]++;
                break;
            case "MOo":
                cells[index]--;
                break;
            case "moO":
                index++;
                break;
            case "mOo":
                index--;
                break;
            case "moo":
                lvl = 1;
                if (cells[index] != 0) {
                    while (lvl > 0) {
                        i--;
                        if (Objects.equals(arr[i].toString(), "MOO"))
                            lvl--;
                        else if (Objects.equals(arr[i].toString(), "moo"))
                            lvl++;
                    }
                }
                break;
            case "MOO":
                lvl = 1;
                if (cells[index] == 0) {
                    while (lvl > 0) {
                        i++;
                        if (Objects.equals(arr[i].toString(), "MOO"))
                            lvl++;
                        else if (Objects.equals(arr[i].toString(), "moo"))
                            lvl--;
                    }
                }
                break;
            case "OOM":
                System.out.print(cells[index]);
                break;
            case "oom":
                //
                break;
            case "mOO":
                i++;
                break;
            case "Moo":
                if (cells[index] != 0)
                    System.out.print((char)cells[index]);
                break;
            case "OOO":
                cells[index] = 0;
                break;
            default:
                break;
        }
    }
    public static void main(String[] args) throws FileNotFoundException {

        //Вводные данные
        Scanner in = new Scanner(System.in);
        //System.out.println("Введите путь к файлу:");
        //String path = in.nextLine();
        String path = "Hello.txt";
        Scanner s = new Scanner(new File(path));
        ArrayList arrlist = new ArrayList();
        while (s.hasNext()) {
            arrlist.add(s.next());
        }
        Object[] arr = arrlist.toArray();
        int register = -1;
        int lvl = 0, index = 0, ind = 0, i = 0;
        Stack stack = new Stack();
        Map<String,String> dict = new HashMap();

        //Обработка MOO и moo
        for (Object item : arr) {
            switching(item, arr);
        }

    }
}

