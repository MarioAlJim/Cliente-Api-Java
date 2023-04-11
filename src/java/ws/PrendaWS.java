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
    public List<Prenda> getAll(@Context final HttpServletResponse response){
        List<Prenda> list = null;
        response.setStatus(200);
        try { response.flushBuffer(); }catch(Exception e){}
        list = PrendaDAO.getAllPrendas();
        return list;
    }
    
    @Path("getprendabyId/{idPrenda}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Prenda> getCatalogoByIdTipo(@PathParam("idPrenda") int idprenda, @Context final HttpServletResponse response) {
        List<Prenda> list = null;
        if (idprenda != 0) {
            response.setStatus(HttpServletResponse.SC_OK);
            list = PrendaDAO.getPrendaById(idprenda);
            try { response.flushBuffer(); }catch(Exception e){}
        }  else{
            response.setStatus(400); 
        }
        try { response.flushBuffer(); }catch(Exception e){}
        return list;
    }
    
    @Path("buscarprendas/{description}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Prenda> getCatalogoByDescription(@PathParam("description") String description, @Context final HttpServletResponse response) {
        List<Prenda> list = null;
        if(description != null) {
            list = PrendaDAO.getPrendaByDescription(description);
            response.setStatus(HttpServletResponse.SC_OK);
        } else {
            response.setStatus(400);
        }
        try { response.flushBuffer(); }catch(Exception e){}
        return list;
    }
    
    @POST
    @Path("registrarPrenda")
    @Produces(MediaType.APPLICATION_JSON)
    public Mensaje registrarPrenda(
            @FormParam("idPrenda") Integer idPrenda,
            @FormParam("idCategoria") Integer idCategoria,
            @FormParam("piezas") Integer piezas,
            @FormParam("serie") String serie,
            @FormParam("porcentajePrestamo") double porcentajePrestamo,
            @FormParam("idSubcategoria") Integer idSubCategoria,
            @FormParam("descripcion") String descripcion,
            @FormParam("prestamo") double prestamo,
            @FormParam("modelo") String modelo,
            @FormParam("avaluo") double avaluo,
            @Context final HttpServletResponse response) {
        Prenda prenda = new Prenda(idPrenda, idCategoria, piezas, serie, porcentajePrestamo, idSubCategoria, descripcion, prestamo, modelo, avaluo);
        Mensaje mensaje = null;
        if(idPrenda != null && 
                idCategoria != null &&
                piezas != null &&
                serie != null && !serie.isEmpty() &&
                porcentajePrestamo != 0 &&
                idSubCategoria != null &&
                descripcion != null && !descripcion.isEmpty() &&
                prestamo != 0 &&
                modelo != null && !modelo.isEmpty() &&
                avaluo != 0) {
            mensaje = PrendaDAO.registerPrenda(prenda);
            response.setStatus(202);
        } else {
            response.setStatus(400);
        }
        try { response.flushBuffer(); }catch(Exception e){}
        return mensaje;
    }
    
    @PUT
    @Path("actualizarprenda")
    @Produces(MediaType.APPLICATION_JSON)
    public Mensaje actualziarPrenda (
            @FormParam("idPrenda") Integer idPrenda,
            @FormParam("idCategoria") Integer idCategoria,
            @FormParam("piezas") Integer piezas,
            @FormParam("serie") String serie,
            @FormParam("porcentajePrestamo") double porcentajePrestamo,
            @FormParam("idSubcategoria") Integer idSubCategoria,
            @FormParam("descripcion") String descripcion,
            @FormParam("prestamo") double prestamo,
            @FormParam("modelo") String modelo,
            @FormParam("avaluo") double avaluo,
            @Context final HttpServletResponse response) {
        Prenda prenda = new Prenda(idPrenda, idCategoria, piezas, serie, porcentajePrestamo, idSubCategoria, descripcion, prestamo, modelo, avaluo);
        Mensaje mensaje = null;
        if(idPrenda != null && 
                idCategoria != null &&
                piezas != null &&
                serie != null && !serie.isEmpty() &&
                porcentajePrestamo != 0 &&
                idSubCategoria != null &&
                descripcion != null && !descripcion.isEmpty() &&
                prestamo != 0 &&
                modelo != null && !modelo.isEmpty() &&
                avaluo != 0) {
            mensaje = PrendaDAO.updatePrenda(prenda);
            response.setStatus(202);
        } else {
            response.setStatus(400);
        }
        
        try { response.flushBuffer(); }catch(Exception e){}
        return mensaje;
    } 
    
    @DELETE
    @Path("eliminarprenda")
    @Produces(MediaType.APPLICATION_JSON)
    public Mensaje eliminarPrenda (
            @FormParam("idPrenda") Integer idprenda, 
            @Context final HttpServletResponse response) {
        Mensaje resultado = null;
        if(idprenda != null){
            resultado = PrendaDAO.deletePrenda(idprenda);
            response.setStatus(202);
        } else {
            response.setStatus(400);
        }
        try { response.flushBuffer(); }catch(Exception e){}
        return resultado;
    } 

    @Context
    private UriInfo context;

    public PrendaWS() {
    }
}
