package cn.kzhou.webservice;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;;

@Path("/studentService")
@Produces(MediaType.APPLICATION_JSON)
public interface StudentService {
    @GET
    @Path("/status")
    public String getStatus();

    @GET
    @Path("/students/{index}")
    public StudentVo getStudentById(@PathParam("index") Integer id);

    @GET
    @Path("/students")
    public StudentListVo getStudentList();
}
