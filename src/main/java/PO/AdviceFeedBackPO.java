package PO;

import other.AdviceFeedBackState;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "AdviceFeedBackPO")
public class AdviceFeedBackPO implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private AdviceFeedBackState state;
    private String AdviceFeedBack_content;
    private String AdviceId;
    private String userId;
    private LocalDate senddate;
    private LocalDate replydate;
    private String replycontent;

    public AdviceFeedBackPO() {
    }

    public String getAdviceFeedBack_content() {
        return AdviceFeedBack_content;
    }

    public void setAdviceFeedBack_content(String adviceFeedBack_content) {
        AdviceFeedBack_content = adviceFeedBack_content;
    }

    @Id
    public String getAdviceId() {
        return AdviceId;
    }

    public void setAdviceId(String adviceId) {
        AdviceId = adviceId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public AdviceFeedBackState getState() {
        return state;
    }

    public void setState(AdviceFeedBackState state) {
        this.state = state;
    }

    public LocalDate getSenddate() {
        return senddate;
    }

    public void setSenddate(LocalDate senddate) {
        this.senddate = senddate;
    }

    public LocalDate getReplydate() {
        return replydate;
    }

    public void setReplydate(LocalDate replydate) {
        this.replydate = replydate;
    }

    public String getReplycontent() {
        return replycontent;
    }

    public void setReplycontent(String replycontent) {
        this.replycontent = replycontent;
    }


}
