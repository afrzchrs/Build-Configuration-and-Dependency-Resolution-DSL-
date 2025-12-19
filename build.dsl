PROJECT "reservasihotel" FROM "C:/javaprojects/reservasihotel_copy" {

    TASK run:
        ECHO ">>> [1] Menata File..."
        ORGANIZE

        FIX_DEPENDENCIES

        ECHO ">>> [2] Mengompilasi..."
        RUN "COMPILE"
        
        ECHO ">>> [3] Menjalankan..."
        RUN "START reservasihotel.Main"
    END
}