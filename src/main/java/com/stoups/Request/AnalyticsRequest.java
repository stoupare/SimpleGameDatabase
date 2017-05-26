package com.stoups.Request;

/**
 * Created by astouparenko on 5/1/2017.
 */
public class AnalyticsRequest extends BaseRequest {

    Boolean restrictedContent;

    public Boolean getRestrictedContent() {
        return restrictedContent;
    }

    public void setRestrictedContent(Boolean restrictedContent) {
        this.restrictedContent = restrictedContent;
    }


}
