package ws;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import mybatis.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import pojos.Catalogo;

@Path("catalogos")
public class CatalogoWS {
    
    @Path("all")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Catalogo> getAll(){
        List<Catalogo> list = new ArrayList<Catalogo>();
        Catalogo c;
        for(int i = 1; i <= 100; i++ ){
            c = new Catalogo(i, "Catalogo prueba " +1, 2000+i, i);
            list.add(c);
        }
        return list;
    }
    
    @Path("byId/{idcatalogo}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Catalogo getCatalogoById (@PathParam("idcatalogo") Integer idcatalogo){
        Catalogo c;
        c = new Catalogo(idcatalogo, "Catalogo "+idcatalogo, 2000+idcatalogo, 0);
        return c;
    }
    
    @Path("allbd")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Catalogo> getAllBd (){
        List<Catalogo> list = null;
        SqlSession conn = MyBatisUtil.getSession();
        if(conn != null) {
            try {
                list = conn.selectList("Catalogo.getAllCatalogos");
            } catch(Exception ex) {
                ex.printStackTrace();
            } finally {
                conn.close();
            }
        }
        return list;
    }
            
    
    
    @Context
    private UriInfo context;

    
    public CatalogoWS() {
        
    }
}
