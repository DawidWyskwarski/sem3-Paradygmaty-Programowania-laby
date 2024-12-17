module type OBSLUGA_KOLEJKI =
sig
  type 'a tk
  exception Pusta of string
  val tworz_pusta: unit -> 'a tk
  val do_kolejki: 'a * 'a tk -> 'a tk
  val z_kolejki: 'a tk -> 'a tk
  val pierwszy_element: 'a tk -> 'a
  val kolejka_pusta: 'a tk -> bool
end;;

module Queue : OBSLUGA_KOLEJKI =
struct 
  type 'a tk = EmptyQueue| Queue of 'a * 'a tk
  
  exception Pusta of string
      
  let tworz_pusta() =
    EmptyQueue
      
  let rec do_kolejki(elem,queue) = 
    match queue with
    | EmptyQueue -> Queue(elem,EmptyQueue)
    | Queue(e,q) -> Queue(e, do_kolejki(elem,q))
                      
  let z_kolejki = function
      Queue(e,q) -> q
    | EmptyQueue -> raise (Pusta "the queue is empty" ) 
      
  let pierwszy_element = function 
      Queue(e,_) -> e 
    | EmptyQueue -> raise (Pusta "the queue is empty" ) 
      
  let kolejka_pusta = function 
      EmptyQueue -> true
    | _ -> false
end;;
  