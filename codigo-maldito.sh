# ================================================================================
# codigo-maldito.sh
# -------------
# Autor: Dr.XGB
# ================================================================================


# ----------------------------------------------------------
# Sub-rotinas
# ----------------------------------------------------------

# Escrever título da solução
write_solution_title()
{
    echo "***"
    echo ""
    echo $1
    echo "----------------"
    echo ""
}


# ----------------------------------------------------------

# Cabeçalho
clear
echo "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-="
echo "           DESAFIO CÓDIGO MALDITO"
echo "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-="
echo ""

# Solução estruturada
write_solution_title "1 - Estruturada"
./scripts/estrutural.sh

# Solução orientada a objetos
write_solution_title "2 - Orientada a Objetos"

# Solução estrutural
write_solution_title "3 - Funcional"