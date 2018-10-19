--------------------------------------------------------
--  DDL for Package PKG_CHR_CHARGES_CALL
--------------------------------------------------------

  CREATE OR REPLACE PACKAGE "MFB"."PKG_CHR_CHARGES_CALL" IS
  
  procedure PRO_RUN(PRB_FM IN OUT OTR_FM, PNI_CURRPOSITION IN NUMBER);
  FUNCTION PRO_FM RETURN OTR_FM;
  FUNCTION PRO_HEADER RETURN OTR_FM_HEADER;
  FUNCTION PRO_ATTR RETURN OTT_SES_ATTR;
  FUNCTION PRO_FTM RETURN OTT_FTM;
  FUNCTION PRO_TAB RETURN OTT_TAB;
  FUNCTION PRO_MSG RETURN OTT_USER_MSG;  
  FUNCTION PRO_REC RETURN OTT_REC;  
  FUNCTION PRO_FIELD RETURN OTT_FIELD;
  
END;

/
