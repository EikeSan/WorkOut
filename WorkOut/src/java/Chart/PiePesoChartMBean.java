package Chart;

import DAO.PesoDAO;
import Model.Peso;
import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class PiePesoChartMBean implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    
    private String pieChartData;
    private List<Peso> pieDataList;
    private static List<Peso> listaUm;
    
    public PiePesoChartMBean() {
//        this.pieDataList = PiePesoChartData.getPieDataList();
        this.pieDataList = this.listaUm;
          
    }
    
    public void geraLista(String email) {
        PesoDAO dao = new PesoDAO();
        this.listaUm = dao.listaChart(email);
        
    }
    
    public String getPieChartData() {
        if (pieChartData == null || pieChartData.trim().length() <= 0) {
            populateData();
        }
        return pieChartData;
    }
    
    private void populateData() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Peso pieData : pieDataList) {
            stringBuilder.append("[");
            stringBuilder.append("'");
            stringBuilder.append(pieData.getData());
            stringBuilder.append("'");
            stringBuilder.append(",");
            stringBuilder.append(pieData.getPeso());
            stringBuilder.append("]");
            stringBuilder.append(",");
        }
        pieChartData = stringBuilder.toString().substring(0,
                stringBuilder.toString().length() - 1);
    }
}
