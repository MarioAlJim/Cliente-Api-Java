package ws;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.DELETE;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.FormParam;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import modelDAO.PrendaDAO;
import pojos.Prenda;
import pojos.Mensaje;


@Path("prendas")
public class PrendaWS {
    
    @Path("getall")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Prenda> getAll(){
        List<Prenda> list = null;
        list = PrendaDAO.getAllPrendas();
        return list;
    }
    
    @Path("getprendabyId/{idPrenda}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Prenda> getCatalogoByIdTipo(@PathParam("idPrenda") int idprenda, @Context final HttpServletResponse response) {
        if (idprenda != 0) {
            response.setStatus(HttpServletResponse.SC_CREATED);
        }  else{
            response.setStatus(400); 
        }
        List<Prenda> list = null;
        list = PrendaDAO.getPrendaById(idprenda);
        try { response.flushBuffer(); }catch(Exception e){}
        return list;
    }
    
    @Path("buscarprendas/{description}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Prenda> getCatalogoByDescription(@PathParam("description") String description) {
        List<Prenda> list = null;
        list = PrendaDAO.getPrendaByDescription(description);
        return list;
    }
    
    @POST
    @Path("registrarPrenda")
    @Produces(MediaType.APPLICATION_JSON)
    public Mensaje registrarPrenda(
            @FormParam("idPrenda") int idPrenda,
            @FormParam("idCategoria") int idCategoria,
            @FormParam("piezas") int piezas,
            @FormParam("serie") String serie,
            @FormParam("porcentajePrestamo") double porcentajePrestamo,
            @FormParam("idSubcategoria") int idSubCategoria,
            @FormParam("descripcion") String descripcion,
            @FormParam("prestamo") double prestamo,
            @FormParam("modelo") String modelo,
            @FormParam("avaluo") double avaluo ) {
        Prenda prenda = new Prenda(idPrenda, idCategoria, piezas, serie, porcentajePrestamo, idSubCategoria, descripcion, prestamo, modelo, avaluo);
        Mensaje mensaje = null;
        mensaje = PrendaDAO.registerPrenda(prenda);
        return mensaje;
    }
    
    @PUT
    @Path("actualizarprenda")
    @Produces(MediaType.APPLICATION_JSON)
    public Mensaje actualziarPrenda (
            @FormParam("idPrenda") int idPrenda,
            @FormParam("idCategoria") int idCategoria,
            @FormParam("piezas") int piezas,
            @FormParam("serie") String serie,
            @FormParam("porcentajePrestamo") double porcentajePrestamo,
            @FormParam("idSubcategoria") int idSubCategoria,
            @FormParam("descripcion") String descripcion,
            @FormParam("prestamo") double prestamo,
            @FormParam("modelo") String modelo,
            @FormParam("avaluo") double avaluo ) {
        Prenda prenda = new Prenda(idPrenda, idCategoria, piezas, serie, porcentajePrestamo, idSubCategoria, descripcion, prestamo, modelo, avaluo);
        Mensaje mensaje = null;
        mensaje = PrendaDAO.updatePrenda(prenda);
        return mensaje;
    } 
    
    @DELETE
    @Path("eliminarprenda/{idPrenda}")
    @Produces(MediaType.APPLICATION_JSON)
    public Mensaje eliminarPrenda (
            @PathParam("idPrenda") int idprenda) {
        Mensaje resultado = null;
        resultado = PrendaDAO.deletePrenda(idprenda);
        return resultado;
    } 

    @Context
    private UriInfo context;

    public PrendaWS() {
    }
}
