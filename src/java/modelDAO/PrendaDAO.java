package modelDAO;

import java.util.List;
import mybatis.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import pojos.Mensaje;
import pojos.Prenda;

public class PrendaDAO {
    
    public static List<Prenda> getAllPrendas (){
        List<Prenda> list = null;
        SqlSession conn = MyBatisUtil.getSession();
        if(conn != null) {
            try {
                list = conn.selectList("Prenda.getAllPrendas");
            } catch(Exception ex) {
                ex.printStackTrace();
            } finally {
                conn.close();
            }
        }
        return list;
    }
    
    public static List<Prenda> getPrendaById (int idPrenda){
        List<Prenda> list = null;
        SqlSession conn = MyBatisUtil.getSession();
        if(conn != null) {
            try {
                list = conn.selectList("Prenda.getPrendaById", idPrenda);
            } catch(Exception ex) {
                ex.printStackTrace();
            } finally {
                conn.close();
            }
        }
        return list;
    }
    
    public static List<Prenda> getPrendaByDescription (String description){
        List<Prenda> list = null;
        SqlSession conn = MyBatisUtil.getSession();
        if(conn != null) {
            try {
                list = conn.selectList("Prenda.searchPrenda", description);
            } catch(Exception ex) {
                ex.printStackTrace();
            } finally {
                conn.close();
            }
        }
        return list;
    }

    public static Mensaje registerPrenda(Prenda prenda) {
        Mensaje mensaje = null;
        SqlSession conn = MyBatisUtil.getSession();
        if(conn != null) {
            try {
                conn.insert("Prenda.registerPrenda", prenda);
                conn.commit();
                mensaje = new Mensaje("Prenda registrada exitosamente", false);
            } catch(Exception ex) {
                mensaje = new Mensaje(ex.getMessage(), true);
            } finally {
                conn.close();
            }
        }
        return mensaje;
    }
    
    public static Mensaje updatePrenda(Prenda prenda) {
        Mensaje resultado = null;
        SqlSession conn = MyBatisUtil.getSession();
        if(conn != null) {
            try {
                conn.update("Prenda.updatePrenda", prenda);
                conn.commit();
                resultado = new Mensaje("Prenda actualizada exitosamente", false);
            } catch(Exception ex) {
                resultado = new Mensaje(ex.getMessage(), true);
            } finally {
                conn.close();
            }
        }
        return resultado;
    }
    
    public static Mensaje deletePrenda(int idprenda) {
        Mensaje resultado = new Mensaje();
        SqlSession conn = MyBatisUtil.getSession();
        if(conn != null) {
            try {
                conn.delete("Prenda.eliminarCatalogo", idprenda);
                conn.commit();
                resultado = new Mensaje("Prenda eliminada exitosamente", false);
            } catch(Exception ex) {
                resultado = new Mensaje(ex.getMessage(), true);
            } finally {
                conn.close();
            }
        }
        return resultado;
    }
    
}
