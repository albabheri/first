package com.first.app.util;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class SkipOutputStream extends FilterOutputStream {

    private int skipLength = 0;
    private int cekLength = 0;

    public SkipOutputStream(OutputStream out, int skipLength) {
        super(out);
        this.skipLength = skipLength;
    }
    
    @Override
    public void write(int b) throws IOException {
    	if ( cekLength >= skipLength ){
    		
    	} else {
            out.write(b);
            cekLength++;
    	}
    }

    @Override
    public void write(byte[] b) throws IOException {
        write(b, 0, b.length);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
    	if ( cekLength + len > skipLength ){
    		int dif = skipLength - cekLength;
    		out.write(b, off + dif, len - dif);
    		cekLength = skipLength;
    	} else {
            out.write(b, off, len);
            cekLength += len;
    	}

    }


    @Override
    public void close() throws IOException {
    	super.close();
    }
    
}
