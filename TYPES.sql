--------------------------------------------------------
--  DDL for Type ADR_CON_CUEN
--------------------------------------------------------

  CREATE OR REPLACE TYPE "MFB"."ADR_CON_CUEN" AS OBJECT(
  NROCUENTA NUMBER(10),
  CODESTADOCUENTA VARCHAR2(1),
  ESTADOCUENTA VARCHAR2(15),
  TIPOPROD VARCHAR2(10),
  NOMPROD VARCHAR2(40),
  CCI VARCHAR2(30),
  CODMONEDA NUMBER(2),
  MONEDA VARCHAR2(20),
  SALDOTOT NUMBER(18,6),
  SALDONODISP NUMBER(18,6),
  SALDODISP NUMBER(18,6),
  CONSTRUCTOR FUNCTION ADR_CON_CUEN RETURN SELF AS RESULT
)
/
CREATE OR REPLACE TYPE BODY "MFB"."ADR_CON_CUEN" IS
     CONSTRUCTOR FUNCTION ADR_CON_CUEN RETURN SELF AS RESULT IS
       BEGIN
  SELF.NROCUENTA := NULL;
  SELF.CODESTADOCUENTA := NULL;
  SELF.ESTADOCUENTA := NULL;
  SELF.TIPOPROD := NULL;
  SELF.NOMPROD := NULL;
  SELF.CCI := NULL;
  SELF.CODMONEDA := NULL;
  SELF.MONEDA := NULL;
  SELF.SALDOTOT := NULL;
  SELF.SALDONODISP := NULL;
  SELF.SALDODISP := NULL;

        RETURN;
       END ADR_CON_CUEN;
END;


/
--------------------------------------------------------
--  DDL for Type ADR_CON_MOV
--------------------------------------------------------

  CREATE OR REPLACE TYPE "MFB"."ADR_CON_MOV" AS OBJECT(
  FECHMOV DATE,
  TIPMOV VARCHAR2(360),
  DESESTA VARCHAR2(35),
  SIGNO VARCHAR2(1),
  MTOTRX NUMBER(18,6),
  CONSTRUCTOR FUNCTION ADR_CON_MOV RETURN SELF AS RESULT
)
/
CREATE OR REPLACE TYPE BODY "MFB"."ADR_CON_MOV" IS
     CONSTRUCTOR FUNCTION ADR_CON_MOV RETURN SELF AS RESULT IS
       BEGIN

  SELF.FECHMOV := NULL;
  SELF.TIPMOV := NULL;
  SELF.DESESTA := NULL;
  SELF.SIGNO := NULL;
  SELF.MTOTRX := NULL;

        RETURN;
       END ADR_CON_MOV;
END;


/
--------------------------------------------------------
--  DDL for Type ADR_CON_TAR
--------------------------------------------------------

  CREATE OR REPLACE TYPE "MFB"."ADR_CON_TAR" AS OBJECT(
  NROTARJETA VARCHAR2(19),
  TIPTARJETA VARCHAR2(1),
  NRORELCUENTA NUMBER(10),
  CODESTADOTAR NUMBER(4),
  ESTADOTAR VARCHAR2(100),
  CODCAUSABLQ NUMBER(4),
  NOMCAUSABLQ VARCHAR2(100),
  ACTTARJETA DATE,
  EXPTARJETA DATE,    
  CONSTRUCTOR FUNCTION ADR_CON_TAR RETURN SELF AS RESULT
)
/
CREATE OR REPLACE TYPE BODY "MFB"."ADR_CON_TAR" IS
     CONSTRUCTOR FUNCTION ADR_CON_TAR RETURN SELF AS RESULT IS
       BEGIN

  SELF.NROTARJETA := NULL;
  SELF.TIPTARJETA := NULL;
  SELF.NRORELCUENTA := NULL;
  SELF.CODESTADOTAR := NULL;
  SELF.ESTADOTAR := NULL;
  SELF.CODCAUSABLQ := NULL;
  SELF.NOMCAUSABLQ := NULL;
  SELF.ACTTARJETA := NULL;
  SELF.EXPTARJETA := NULL;

        RETURN;
       END ADR_CON_TAR;
END;


/
--------------------------------------------------------
--  DDL for Type ADT_CON_CUEN
--------------------------------------------------------

  CREATE OR REPLACE TYPE "MFB"."ADT_CON_CUEN" is table of ADR_CON_CUEN


/
--------------------------------------------------------
--  DDL for Type ADT_CON_MOV
--------------------------------------------------------

  CREATE OR REPLACE TYPE "MFB"."ADT_CON_MOV" is table of ADR_CON_MOV


/
--------------------------------------------------------
--  DDL for Type ADT_CON_TAR
--------------------------------------------------------

  CREATE OR REPLACE TYPE "MFB"."ADT_CON_TAR" is table of ADR_CON_TAR


/
--------------------------------------------------------
--  DDL for Type OTR_CAP_MOVIMIENTOS
--------------------------------------------------------

  CREATE OR REPLACE TYPE "MFB"."OTR_CAP_MOVIMIENTOS" AS OBJECT(	
     FECHMOV	DATE
    ,TIPMOV	  VARCHAR2(360)
    ,DESESTA	VARCHAR2(35)
    ,SIGNO	  VARCHAR2(1)
    ,MTOTRX	  NUMBER (18,6)
    ,CONSTRUCTOR FUNCTION OTR_CAP_MOVIMIENTOS RETURN SELF AS RESULT	
);
/
CREATE OR REPLACE TYPE BODY "MFB"."OTR_CAP_MOVIMIENTOS" IS
     CONSTRUCTOR FUNCTION OTR_CAP_MOVIMIENTOS RETURN SELF AS RESULT IS
       BEGIN
  SELF.FECHMOV := NULL;
  SELF.TIPMOV := NULL;
  SELF.DESESTA := NULL;
  SELF.SIGNO := NULL;
  SELF.MTOTRX := NULL;
        RETURN;
       END OTR_CAP_MOVIMIENTOS;
END;

/
--------------------------------------------------------
--  DDL for Type OTR_CAP_VISTA
--------------------------------------------------------

  CREATE OR REPLACE TYPE "MFB"."OTR_CAP_VISTA" AS OBJECT(	

     NROCUENTA	      NUMBER(10)
    ,CODESTADOCUENTA	VARCHAR2(1)
    ,ESTADOCUENTA	    VARCHAR2(15)
    ,TIPOPROD	        VARCHAR2(10)
    ,NOMPROD	        VARCHAR2(40)
    ,CCI	            VARCHAR2(30)
    ,CODMONEDA	      NUMBER(2)
    ,MONEDA	          VARCHAR2(20)
    ,SALDOTOT	        NUMBER(18,6)
    ,SALDONODISP	    NUMBER(18,6)
    ,SALDODISP	      NUMBER(18,6)
    ,CONSTRUCTOR FUNCTION OTR_CAP_VISTA RETURN SELF AS RESULT	
);
/
CREATE OR REPLACE TYPE BODY "MFB"."OTR_CAP_VISTA" IS
     CONSTRUCTOR FUNCTION OTR_CAP_VISTA RETURN SELF AS RESULT IS
       BEGIN
  SELF.NROCUENTA := NULL;
  SELF.CODESTADOCUENTA := NULL;
  SELF.ESTADOCUENTA := NULL;
  SELF.TIPOPROD := NULL;
  SELF.NOMPROD := NULL;
  SELF.CCI := NULL;
  SELF.CODMONEDA := NULL;
  SELF.MONEDA := NULL;
  SELF.SALDOTOT := NULL;
  SELF.SALDONODISP := NULL;
  SELF.SALDODISP := NULL;

        RETURN;
       END OTR_CAP_VISTA;
END;

/
--------------------------------------------------------
--  DDL for Type OTR_FIELD
--------------------------------------------------------

  CREATE OR REPLACE TYPE "MFB"."OTR_FIELD" as object(
  NEWVAL VARCHAR2(4000),
  OLDVAL VARCHAR2(4000),
  DATATYPE VARCHAR2(2),
  ID VARCHAR2(80),
  constructor function "OTR_FIELD" return self as result
)

/
--------------------------------------------------------
--  DDL for Type OTR_FM
--------------------------------------------------------

  CREATE OR REPLACE TYPE "MFB"."OTR_FM" as object(
  HEADER OTR_FM_HEADER,
  ATTRLIST OTT_SES_ATTR,
  FTMS OTT_FTM,
  MAINFTM	NUMBER,
  MAINBTID VARCHAR2(50),
  RESPONSE NUMBER,
  constructor function "OTR_FM" return self as result
)

/
--------------------------------------------------------
--  DDL for Type OTR_FM_HEADER
--------------------------------------------------------

  CREATE OR REPLACE TYPE "MFB"."OTR_FM_HEADER" as object(
  USERID VARCHAR2(50),
  LANGUAGEID VARCHAR2(30),
  BRANCHID NUMBER,
  OFFICEID NUMBER,
  DEPTOID	NUMBER,
  TERMINALID VARCHAR2(255),
  MESSENGERID VARCHAR2(30),
  SESSIONKEY VARCHAR2(512),
  EXTERNALREFERENCE	VARCHAR2(500),
  REFERENCEUSER	VARCHAR2(30),
  PROCESSTYPE	VARCHAR2(30),
  constructor function "OTR_FM_HEADER" return self as result
)

/
--------------------------------------------------------
--  DDL for Type OTR_FTM
--------------------------------------------------------

  CREATE OR REPLACE TYPE "MFB"."OTR_FTM" as object(
  TABS OTT_TAB,
  FISA_OBJECT_ID VARCHAR2(255),
  ID VARCHAR2(255),
  DATAKEY	VARCHAR2(4000),
  MESSAGELIST	OTT_USER_MSG,
  constructor function "OTR_FTM" return self as result
)

/
--------------------------------------------------------
--  DDL for Type OTR_REC
--------------------------------------------------------

  CREATE OR REPLACE TYPE "MFB"."OTR_REC" as object(
  FIELDS OTT_FIELD,
  RECSTATUS VARCHAR2(30),
  constructor function "OTR_REC" return self as result
)

/
--------------------------------------------------------
--  DDL for Type OTR_SES_ATTR
--------------------------------------------------------

  CREATE OR REPLACE TYPE "MFB"."OTR_SES_ATTR" as object(
  attrName VARCHAR2(30),
  attrValue	VARCHAR2(4000),
  constructor function "OTR_SES_ATTR" return self as result
)

/
--------------------------------------------------------
--  DDL for Type OTR_TAB
--------------------------------------------------------

  CREATE OR REPLACE TYPE "MFB"."OTR_TAB" as object(
  RECS OTT_REC,
  MULTIVALUE VARCHAR2(1),
  PARENT NUMBER,
  ID VARCHAR2(80),
  constructor function "OTR_TAB" return self as result
)

/
--------------------------------------------------------
--  DDL for Type OTR_USER_MSG
--------------------------------------------------------

  CREATE OR REPLACE TYPE "MFB"."OTR_USER_MSG" as object(
  TEXT VARCHAR2(4000),
  MSGTYPE	VARCHAR2(30),
  constructor function "OTR_USER_MSG" return self as result
)

/
--------------------------------------------------------
--  DDL for Type OTT_CAP_MOVIMIENTOS
--------------------------------------------------------

  CREATE OR REPLACE TYPE "MFB"."OTT_CAP_MOVIMIENTOS" 
         as table of OTR_CAP_MOVIMIENTOS

/
--------------------------------------------------------
--  DDL for Type OTT_CAP_VISTA
--------------------------------------------------------

  CREATE OR REPLACE TYPE "MFB"."OTT_CAP_VISTA" 
         as table of OTR_CAP_VISTA

/
--------------------------------------------------------
--  DDL for Type OTT_FIELD
--------------------------------------------------------

  CREATE OR REPLACE TYPE "MFB"."OTT_FIELD" as table of OTR_FIELD

/
--------------------------------------------------------
--  DDL for Type OTT_FTM
--------------------------------------------------------

  CREATE OR REPLACE TYPE "MFB"."OTT_FTM" as table of OTR_FTM

/
--------------------------------------------------------
--  DDL for Type OTT_REC
--------------------------------------------------------

  CREATE OR REPLACE TYPE "MFB"."OTT_REC" as table of OTR_REC

/
--------------------------------------------------------
--  DDL for Type OTT_SES_ATTR
--------------------------------------------------------

  CREATE OR REPLACE TYPE "MFB"."OTT_SES_ATTR" as table of OTR_SES_ATTR

/
--------------------------------------------------------
--  DDL for Type OTT_TAB
--------------------------------------------------------

  CREATE OR REPLACE TYPE "MFB"."OTT_TAB" as table of OTR_TAB

/
--------------------------------------------------------
--  DDL for Type OTT_USER_MSG
--------------------------------------------------------

  CREATE OR REPLACE TYPE "MFB"."OTT_USER_MSG" as table of OTR_USER_MSG

/
