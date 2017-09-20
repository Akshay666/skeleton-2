package controllers;

import api.CreateReceiptRequest;
import api.ReceiptResponse;
import dao.ReceiptDao;
import dao.TagsDao;
import generated.tables.records.ReceiptsRecord;
import generated.tables.records.TagsRecord;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.ArrayList;

import static java.util.stream.Collectors.toList;

@Path("/receipts")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ReceiptController {
    final ReceiptDao receipts;
    final TagsDao tags;

    public ReceiptController(ReceiptDao receipts, TagsDao tags) {
        this.receipts = receipts;
        this.tags = tags;
    }

    @POST
    public int createReceipt(@Valid @NotNull CreateReceiptRequest receipt) {
        return receipts.insert(receipt.merchant, receipt.amount);
    }

    @GET
    public List<ReceiptResponse> getReceipts() {
        List<ReceiptsRecord> receiptRecords = receipts.getAllReceipts();



        ////k
        List<ReceiptResponse> response = new ArrayList<>();
        for(ReceiptsRecord receiptRecord : receiptRecords){


            ReceiptResponse thisReceiptResponse = new ReceiptResponse();

            thisReceiptResponse.setId(receiptRecord.getId());

            thisReceiptResponse.setMerchant(receiptRecord.getMerchant());

            System.out.println("Amount is :"+receiptRecord.getAmount());
            thisReceiptResponse.setAmount(receiptRecord.getAmount());

            thisReceiptResponse.setCreated(receiptRecord.getUploaded());

            //set Tags
            //Step 1: get tags for receiptID
            List<String> tagsForThisReceiptId = new ArrayList<>();

            List<TagsRecord> tagsRecords = tags.getTagsForReceipt(receiptRecord.getId()); // AKSHAY chng fn name
            for (TagsRecord record: tagsRecords) {
                tagsForThisReceiptId.add(record.getTag());
            }

            thisReceiptResponse.setTags(tagsForThisReceiptId.toArray( new String[tagsForThisReceiptId.size()]));
            response.add(thisReceiptResponse);
        }


        return response;
        ////k
        // return receiptRecords.stream().map(ReceiptResponse::new).collect(toList());
    }
}
