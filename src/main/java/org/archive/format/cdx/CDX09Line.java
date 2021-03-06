package org.archive.format.cdx;

public class CDX09Line extends CDXLine {
	
	CDX09Line(String string, FieldSplitFormat selectNames) {
	    super(string, selectNames);
    }

	@Override
    public String getUrlKey() {
	    return getField(0);
    }

	@Override
    public String getTimestamp() {
	    return getField(1);
    }

	@Override
    public String getOriginalUrl() {
	    return getField(2);
    }

	@Override
    public String getMimeType() {
	    return getField(3);
    }
	
	@Override
	public void setMimeType(String mime)
	{
		setField(3, mime);
	}

	@Override
    public String getStatusCode() {
	    return getField(4);
    }

	@Override
    public String getDigest() {
	    return getField(5);
	}
	
	@Override
    public String getRedirect() {
	    return getField(6);
    }

	@Override
    public String getOffset() {
		return getField(7);
    }

	@Override
    public String getFilename() {
		return getField(8);
    }
}
