type slownik = (int*int) list;;             
             
let rec remove(elem)(s:slownik):slownik = 
  match s with
  | [] -> []
  | head::tail ->
      match head with
      | (elem,1) -> tail
      | (sth,k) when sth = elem -> (elem,k-1) :: tail
      | (n,_) when n > elem -> head::tail
      | _ -> head :: remove(elem)(tail);;        

let slowa = [(1, 3); (2, 1); (3, 2); (4, 6)];;

remove(2)(slowa) 