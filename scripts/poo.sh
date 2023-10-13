# ================================================================================
# estrutural.sh
# -------------
# Autor: Dr.XGB
# -------------
# 
# Execute o script codigo-maldito.sh para que este funcione adequadamente
# ================================================================================


# ----------------------------------------------------------
# Variáveis
# ----------------------------------------------------------

JAR_PATH="./bin/poo.jar"
EXAMINATOR_JAR="./ferramentas/Avaliador.jar"
MAP_FILE="./scripts/map.txt"
DATA_PATTERN="^(\w+):\s*\[\s*((\w+,?\s*)*)\]$"
i=1

# ----------------------------------------------------------

while [ $i -le 50 ]
do
    BOX_FILE="./caixas/caixa$i.txt"
    LOG_FILE="./log/poo/resultado$i.log"

    echo "=========="
    echo "Teste #$i"
    echo "=========="
    echo ""

    # Executar programa
    java -jar $JAR_PATH $BOX_FILE | tee $LOG_FILE
    echo ""

    # Executar avaliador
    java -jar $EXAMINATOR_JAR $BOX_FILE $LOG_FILE $MAP_FILE $DATA_PATTERN | tee -a $LOG_FILE
    echo ""

    # Próxima caixa
    i=`expr $i + 1`
done