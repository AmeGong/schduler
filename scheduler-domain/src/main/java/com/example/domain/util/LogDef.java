package com.example.domain.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public interface LogDef {

    Log DAL_DIGIEST = LogFactory.getLog("DAL_DIGEST");

    Log COMMON_ERROR = LogFactory.getLog("COMMON_ERROR");
}
