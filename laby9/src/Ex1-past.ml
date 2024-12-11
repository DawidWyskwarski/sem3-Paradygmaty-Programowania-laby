type 'a llist = LNil | LCons of 'a * (unit -> 'a llist);;

let rec lfrom n = 
  LCons(n, function ()-> lfrom (n+1));;

let rec ltake(n,list) =
  match (n,list) with
  | (0,_) -> []
  | (_,LNil) -> []
  | (_,LCons(x,xf)) -> x :: ltake(n-1,xf());;

let lRepeat(list) = 
  let rec rep(index,list) =
    match list with
    | LNil -> LNil
    | LCons(h,t) -> let rec repeat(x,k) = 
                      if k < index then
                        LCons(x, function () -> repeat(x*h,k+1))
                      else rep(index+1,t())
        in repeat(h,0)
  in rep(1,list);;

ltake(10, lRepeat(lfrom 1));;