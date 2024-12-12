type slowo = (int*int)

type slownik = slowo list;;

let rec add(s:slownik)(elem):slownik = 
  match s with
  | [] -> [(elem,1)]
  | head::tail -> 
      match head with
      | (value,count) ->
          if value < elem then
            head :: add(tail)(elem)
          else if value = elem then
            (value,count+1) :: tail
          else 
            (elem,1) :: head :: tail;;

let s = [(1,4);(4,7);(8,9);(9,1)];;

add(s)(2);;        
        
            