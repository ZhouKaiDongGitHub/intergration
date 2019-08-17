package cn.kzhou.webservice;

import io.swagger.annotations.*;

import javax.ws.rs.*;
import java.util.List;

@Api(value = "Test UserService", description = "test the swagger API")
public interface UserService {
    // URL = http://localhost:8080/rs_server/webservice/userService/user
    @POST
    @Path("/user")
    @Consumes({ "application/xml", "application/json" })
    public void saveUser(User user);

    // URL = http://localhost:8080/rs_server/webservice/userService/user?id=1
    @DELETE
    @Path("/user")
    @Consumes({ "application/xml" })
    public void delUser(@QueryParam("id") int id);

    // URL = http://localhost:8080/rs_server/webservice/userService/user
    @PUT
    @Path("/user")
    @Consumes({ "application/xml", "application/json" })
    @ApiOperation(value = "update the hotel", notes = "update the hotel", response = User.class)
   public void updateUser(@ApiParam(value = "the hotel" ,required=true)User user);

    // URL = http://localhost:8080/rs_server/webservice/userService/user
    @GET
    @Path("/user")
    @Produces({ "application/xml", "application/json" })
    public List<User> findAllUsers();

    // URL = http://localhost:8080/rs_server/webservice/userService/user/1
    @GET
    @Path("/user/{id}")
    @Consumes({ "application/xml" })
    @Produces({ "application/xml", "application/json" })
    @ApiOperation(value = "get city by state", notes = "Get city by state", response = User.class)
    @ApiResponses(value = {@ApiResponse(code = 405, message = "Invalid input", response = User.class) })
    public User findUserByID(@PathParam("id") @ApiParam(value = "The id of the city" ,required=true )int id);

}
