let transArrayF(array) = 
  if Array.length array = 0 then
    raise(Failure("The matrix is empty!"))
  else
    let rec transRec(result,index) = 
      if index < Array.length array then (
        result.(index) <- (Array.fold_left (fun acc x -> if x<acc then x else acc) array.(index).(0) array.(index));
        transRec(result,index+1))
      else
        result
    in transRec((Array.make (Array.length array) 0 ),0);;


let transArrayI(array) = 
  
  let len =  (Array.length array)
  in let result = Array.make len  0 
  
  in for i=0 to len-1 do 
    result.(i) <- (Array.fold_left (fun acc x -> if x<acc then x else acc) array.(i).(0) array.(i)); 
  done; 
  
  result;;

transArrayF([|[|1;2;3;4|];[|2;1;0;-1|];[|412;634;23;123|]|]);;
transArrayI([|[|1;2;3;4|];[|2;1;0;-1|];[|412;634;23;123|]|]);;
