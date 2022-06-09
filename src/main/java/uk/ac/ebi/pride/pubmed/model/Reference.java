package uk.ac.ebi.pride.pubmed.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.util.StringUtils;

@Data
@Builder
public class Reference implements ReferenceLine{

    String referenceLine;
    private String pmid;
    private String pmcid;
    private String doi;
    private String title;
    private String authorString;
    private String journalTitle;
    private String issue;
    private String volume;
    private String pubYear;
    private String pageInfo;
    private String pubType;


    @Override
    public String getReferenceLine() {
        if (referenceLine == null)
            setReferenceLine();
        return referenceLine;
    }

    private void setReferenceLine() {
        StringBuilder refLine = new StringBuilder();
        refLine.append(getAuthorString());
        refLine.append(' ');
        refLine.append(getTitle());
        refLine.append(' ');
        refLine.append(getJournalTitle());
        refLine.append('.');
        refLine.append(' ');
        refLine.append(getPubYear());
        if (!StringUtils.isEmpty(getVolume())) {
            refLine.append(' ');
            refLine.append(getVolume());
        }
        if (!StringUtils.isEmpty(getIssue())) {
            refLine.append('(');
            refLine.append(getIssue());
            refLine.append(')');
        }
        if (!StringUtils.isEmpty(getPageInfo())) {
            refLine.append(':');
            refLine.append(getPageInfo());
        }
        this.referenceLine = refLine.toString();
    }

    public boolean isPreprint(){
        return (pubType != null) && pubType.equalsIgnoreCase("preprint");
    }

}
