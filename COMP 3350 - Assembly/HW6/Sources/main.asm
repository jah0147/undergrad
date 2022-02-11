;*****************************************************************
;* This stationery serves as the framework for a                 *
;* user application (single file, absolute assembly application) *
;* For a more comprehensive program that                         *
;* demonstrates the more advanced functionality of this          *
;* processor, please see the demonstration applications          *
;* located in the examples subdirectory of the                   *
;* Freescale CodeWarrior for the HC12 Program directory          *
;*****************************************************************

; export symbols
            XDEF Entry, _Startup            ; export 'Entry' symbol
            ABSENTRY Entry        ; for absolute assembly: mark this as application entry point



; Include derivative-specific definitions 

RAMStart    EQU  $0800 
ROMStart    EQU  $4000  ; absolute address to place my code/constant data

; variable/data section

            ORG RAMStart

TABLE       DS.B  1
DIRECTION   DC.B  1
BOUNCE      DC.B  1,0
COUNTER           DC.B  0     ;Will be used to check if the loop should continue



            ORG   ROMStart

Entry:
_Startup:   
            ldx     #BOUNCE
          
            ldab    #$08    
            stab    TABLE
            
loop: 
            cmpa    #20            ;compairs a with 20 to check if the loop should keep going
            beq     done
                
            bsr     update_table   ;Branches to subRoutine
            
            ldaa    COUNTER        ;Loads value in COUNTER
            inca                   ;Increments a
            staa    COUNTER        ;Stores new value into COUNTER
            bra loop               ;Branches back to loop
            
done: 
            rts

            

update_table:          ;update Table subRoutine 

      tst TABLE        ;Tests table to see if a ball is there
      beq setBall      ;If no ball is there, it will go to setBall
      bne ballLocation ;if a ball is there, it will check which direction to change the ball
      
setBall:               ;This will set the ball at position 1 if there is no ball
      ldaa  #1
      ldab   #0
      staa  TABLE
      stab  DIRECTION
      bra   shiftDirection

ballLocation:          ;Checks ball Location
 
      ldaa  #1
      ldab  #128
            
      cmpa  TABLE 
      beq   checkBounce
      
      cmpb  TABLE
      beq   changeDirection2
      
      bne   shiftDirection
      
checkBounce:          ;Checks Bounce
      ldaa  #1      
      cmpa  1,x+
      beq   changeDirection1
      
      bne   shiftDirection
            
      
;changeDirection1 and 2 Changes Direction of ball based on if the ball is at the start or end of the table
changeDirection1:  
      ldaa    #0
      staa    DIRECTION
      bra     shiftDirection
      
changeDirection2:
      ldaa #1
      staa  DIRECTION
      bra   shiftDirection


shiftDirection:    
      ldab    #1
      cmpb    DIRECTION
      bne     shiftLeft
      beq     shiftRight
       
        shiftLeft:    ;Shifts ball to Left
                   lsl TABLE 
                   rts
               
                   
        shiftRight:   ;Shifts ball to Right
                  lsr   TABLE
                  rts
                  
    

                     
            
                   ; result in D

;**************************************************************
;*                 Interrupt Vectors                          *
;**************************************************************
            ORG   $FFFE
            DC.W  Entry           ; Reset Vector
