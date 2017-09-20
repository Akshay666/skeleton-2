package api;

import com.fasterxml.jackson.annotation.JsonProperty;
import generated.tables.records.ReceiptsRecord;
import org.hibernate.validator.constraints.NotEmpty;

import java.math.BigDecimal;
import java.sql.Time;
import java.util.Arrays;

/**
 * This is an API Object.  Its purpose is to model the JSON API that we expose.
 * This class is NOT used for storing in the Database.
 *
 * This ReceiptResponse in particular is the model of a Receipt that we expose to users of our API
 *
 * Any properties that you want exposed when this class is translated to JSON must be
 * annotated with {@link JsonProperty}
 */
public class ReceiptResponse {
    @JsonProperty
    Integer id;

    @JsonProperty
    @NotEmpty
    String merchant;

    @JsonProperty
    BigDecimal amount;

    @JsonProperty
    Time created;

    @JsonProperty
    String[] tags;

    public ReceiptResponse() {
        super();
    }

    public ReceiptResponse(ReceiptsRecord dbRecord) {
        this.merchant = dbRecord.getMerchant();
        this.amount = dbRecord.getAmount();
        this.created = dbRecord.getUploaded();
        this.id = dbRecord.getId();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMerchant() {
        return merchant;
    }

    public void setMerchant(String merchant) {
        this.merchant = merchant;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Time getCreated() {
        return created;
    }

    public void setCreated(Time created) {
        this.created = created;
    }

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        return "ReceiptResponse{" +
                "id=" + id +
                ", merchant='" + merchant + '\'' +
                ", amount=" + amount +
                ", created=" + created +
                ", tags=" + Arrays.toString(tags) +
                '}';
    }
}
