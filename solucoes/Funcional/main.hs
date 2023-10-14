-- =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
--          Módulos
-- =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

import System.IO
import System.Environment


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
--toys :: [Toy]
--toys = [ ARANHA, SAPO, DENTADURA, FANTASMINHA, BRUXINHA, ARANHA, DENTADURA ]

-- Fila de crianças com suas bolsas
kids :: [(Kid, [Toy])]
kids = [ (Samuel, []), (Franklin, []), (Hellen, []), (JC, []), (Daniel, []) ]


-- =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
--          Funções
-- =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

-- Recebe o brinquedo de acordo com o nome
makeToy :: String -> Toy
makeToy name = toy name
    where   toy "ARANHA"        = ARANHA
            toy "SAPO"          = SAPO
            toy "DENTADURA"     = DENTADURA
            toy "FANTASMINHA"   = FANTASMINHA
            toy "BRUXINHA"      = BRUXINHA
            toy _               = error "O brinquedo não existe"

-- Cria uma caixa de brinquedos
makeBox :: String -> [Toy]
makeBox box = [ makeToy item | item <- words box, item /= [] ]


-- Verifica se a criança gosta do brinquedo
likes :: Kid -> Toy -> Bool
Samuel      `likes` SAPO            = True
Franklin    `likes` ARANHA          = True
Hellen      `likes` FANTASMINHA     = True
JC          `likes` BRUXINHA        = True
Daniel      `likes` DENTADURA       = True
likes _ _                           = False


-- Criança guarda o brinquedo na bolsa
takes :: (Kid, [Toy]) -> Toy -> (Kid, [Toy])
takes (kid, bag) toy = (kid, bag ++ [ toy ])


-- Criança recebe o brinquedo
passTo :: Toy -> [(Kid, [Toy])] -> [(Kid, [Toy])]
passTo _ [] = []
passTo toy (kid:kids)
    | kid' `likes` toy      = [kid `takes` toy] ++ kids
    | otherwise             = kid:(toy `passTo` kids)
    where kid' = fst kid


-- Passa os brinquedos para as crianças
distributeTo :: [Toy] -> [(Kid, [Toy])] -> [(Kid, [Toy])]
distributeTo []         []      = []
distributeTo _          []      = []
distributeTo []         kids    = kids
distributeTo (toy:[])   kids    = toy `passTo` kids
distributeTo (toy:toys) kids    =
    let kids' = toys `distributeTo` kids
    in toy `passTo` kids'


-- Escreve o nome da criança e seus brinquedos na bolsa
printKidsBag :: (Kid, [Toy]) -> String
printKidsBag (name, bag) = show name ++ ": " ++ show bag


-- Escreve o resultado final
printResult :: [(Kid, [Toy])] -> IO ()
printResult (kid:[])    = putStrLn (printKidsBag kid)
printResult (kid:kids)  = do
    putStrLn (printKidsBag kid)
    printResult kids


-- =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
--          Execução do programa
-- =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

main = do
    args <- getArgs
    file <- openFile (args !! 0) ReadMode
    box <- hGetContents file
    let toys = makeBox box
    let result = toys `distributeTo` kids
    printResult result