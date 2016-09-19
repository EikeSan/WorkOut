package Chart;

import java.util.ArrayList;
import java.util.List;
import DAO.PesoDAO;
import Model.Peso;


public class PiePesoChartData {

    private static final List<Peso> pieDataList;
    public static String email;
    static {
//        pieDataList = new ArrayList<Peso>(); 
        PesoDAO dao = new PesoDAO();
        pieDataList = dao.listarPorAluno(email);
    }

    public static List<Peso> getPieDataList() {
        return pieDataList;
    }

    public static String getEmail() {
        return email;
    }

    public static void setEmail(String email) {
        PiePesoChartData.email = email;
    }

}
