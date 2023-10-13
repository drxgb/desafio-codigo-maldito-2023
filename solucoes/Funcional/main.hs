-- =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
--          Dados
-- =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

-- Crianças
data Kid = Samuel | Franklin | Hellen | JC | Daniel
    deriving Show

-- Brinquedo
data Toy = ARANHA | SAPO | DENTADURA | FANTASMINHA | BRUXINHA
    deriving Show

-- Caixa de brinquedos
toys :: [Toy]
toys = [ ARANHA, SAPO, DENTADURA, FANTASMINHA, BRUXINHA, ARANHA, DENTADURA ]

-- Fila de crianças
kids :: [Kid]
kids = [ Samuel, Franklin, Hellen, JC, Daniel ]


-- =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
--          Funções
-- =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

-- Verifica se a criança gosta do brinquedo
likes :: Kid -> Toy -> Bool
Samuel      `likes` SAPO            = True
Franklin    `likes` ARANHA          = True
Hellen      `likes` FANTASMINHA     = True
JC          `likes` BRUXINHA        = True
Daniel      `likes` DENTADURA       = True
likes _ _                           = False

-- Distribuir brinquedos às crianças
receive :: [Kid] -> [Toy] -> [(Kid, [Toy])]
receive kids' toys' = 
    [ (kid, [ toy | toy <- toys', kid `likes` toy ]) | kid <- kids' ]


-- =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
--          Execução do programa
-- =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

main = print (kids `receive` toys)