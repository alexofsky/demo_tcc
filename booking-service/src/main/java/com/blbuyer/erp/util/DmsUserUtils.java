package com.blbuyer.erp.util;

import java.security.SecureRandom;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Query;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.lang.Validate;
import org.springframework.stereotype.Service;

import com.google.common.base.Strings;


@Service
public class DmsUserUtils {

    private static SecureRandom random = new SecureRandom();

    public static byte[] generateSalt(int numBytes) {
        Validate.isTrue(numBytes > 0, "numBytes argument must be a positive integer (1 or larger)",
                numBytes);
        byte[] bytes = new byte[numBytes];
        random.nextBytes(bytes);
        return bytes;
    }

    public static String encodeHex(byte[] input) {
        return Hex.encodeHexString(input);
    }

    public static void pipPrepareSql(Query query, String paramterString, Object paramter) {
        try {
            query.setParameter(paramterString, paramter);
        } catch (Throwable e) {
//            logger.error(getFirstRow(getExceptionInfo(e)));
        }
    }
    
    public static String StringCover(Object o) {
        if (o == null) {
            return "";
        } else {
            return o.toString().trim();
        }
    }
    
    public static Date stringToDate(String str) throws ParseException {
        if (!Strings.isNullOrEmpty(str)) {
            return getSdf().parse(str);
        } else {
            return null;
        }
    }
    
    private static SimpleDateFormat getSdf(){
        return new SimpleDateFormat("yyyy-MM-dd");
    }
    
    public static String DateToString(Date date) {
        if (date != null) {
            return getSdf().format(date);
        } else {
            return null;
        }
    }
}
