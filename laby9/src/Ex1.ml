type 'a llist = LNil | LCons of 'a * (unit -> 'a llist);;

let rec lfrom n = 
  LCons(n, function ()-> lfrom (n+1));;

let rec ltake(n,list) =
  match (n,list) with
  | (0,_) -> []
  | (_,LNil) -> []
  | (_,LCons(x,xf)) -> x :: ltake(n-1,xf());;

let repF(list,f) = 
  let rec repf(list,index) =
    match list with
    | LNil -> LNil
    | LCons(lh,lt) -> 
        let rec repeat(count) = 
          if count < f(index) then
            LCons(lh,function () -> repeat(count+1))
          else 
            repf(lt(),index+1)
        in repeat(0)
  in repf(list,1);;

let f x = 2*x - 5;;

ltake(18,repF((lfrom 1),f));;
    