let transArrayF(arrayOfArrays) = 
  let rec transRec(result,index) = 
    if index < Array.length arrayOfArrays then 
      transRec(Array.fold_left (fun acc x -> acc + x) 0 arrayOfArrays.(index) :: result,index+1)
    else
      Array.of_list (List.rev result)
  in transRec([],0);;

let transArrayI(arrayOfArrays) = 
  
  let i = ref 0
  
  in let result = Array.make (Array.length arrayOfArrays)  0 
  
  in while !i < Array.length arrayOfArrays do 
    result.(!i) <- Array.fold_left (fun acc x -> acc + x) 0 arrayOfArrays.(!i);
  
    i := !i + 1
  
  done;
  
  result;;
  
          