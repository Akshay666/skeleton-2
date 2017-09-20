package controllers;

import api.ReceiptResponse;
import dao.TagsDao;
import generated.tables.records.ReceiptsRecord;
import generated.tables.records.TagsRecord;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import javax.validation.constraints.NotNull;
import static java.util.stream.Collectors.toList;

@Path("/tags")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TagsController {
    final TagsDao tagsDao;

    public TagsController(TagsDao tagsDao) {
        this.tagsDao = tagsDao;
    }

//    @Path("/{tag}")
//    @PUT
//    @Consumes(MediaType.APPLICATION_JSON)
//    public int updateTagEntry(@PathParam("tag") String tagName, Integer receipt_id ) {
//        return tagsDao.insert(tagName, receipt_id);
//    }

    @PUT
    @Path("{tag}")
    public void toggleTag(@PathParam("tag") String tag, @NotNull int id) {
        System.out.println("Trying to add tag:"+tag+"for receipt_id:"+id);
        TagsRecord existing = tagsDao.getTag(id,tag);
        if(existing == null){
            tagsDao.insert(tag,id);
        }else{
            System.out.println("Deleting existing tag-record");
            // tagsDao.removeTag(existing);
            tagsDao.delete(tag, id);
        }
        return;
    }

    @Path("/{tag}")
    @GET
    public List<ReceiptResponse> getReceipts(@PathParam("tag") String tagName) {
        List<ReceiptsRecord> receiptRecords = tagsDao.getTaggedReceipts(tagName);
        return receiptRecords.stream().map(ReceiptResponse::new).collect(toList());
    }
}
