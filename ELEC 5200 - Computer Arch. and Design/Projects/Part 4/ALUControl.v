`timescale 1ns / 1ps
module ALUControl( //tells ALU what operation to perform
input [2:0] ALUOp,
input [15:0] Instruction,
output reg [4:0] ALUControlOut
);
reg [2:0] Func4;

parameter //Arithmatic
          A = 3'b001, //Arithmatic instructions
          ADD = 3'b000,
          SUB = 3'b001,
          AND = 3'b010,
          OR = 3'b011,
          XOR = 3'b100,
          SL = 3'b101,
          SR = 3'b110,
          //Immidiate Arithmatic
          I = 3'b010,
          ADDI = 3'b000,
          ANDI = 3'b001,
          ORI = 3'b010,
          XORI = 3'b011,
          SLI = 3'b100,
          SRI = 3'b101,
          //Load Instruction
          LOAD = 3'b011,//only 1 instruction
          //Store Instruction
          STORE = 3'b100,//only 1 instruction
          //Branch
          BRANCH = 3'b101,
          BEQ = 3'b000,
          BGT = 3'b001,
          BGE = 3'b010,
          BLT = 3'b011,
          //Jump and Link Reg
          JALR  = 3'b110; //only 1 instruction

always @ (ALUOp)
begin
Func4 = Instruction[8:6];//sets func4 bits for decoding
ALUControlOut = 0; //sets control to zero at start so no instructions are performed
case (ALUOp)

    A: begin //arithmatic
        case (Func4) //Intruction decoder
            ADD: begin
            ALUControlOut = 1;
            end
            SUB: begin
            ALUControlOut = 2;
            end
            AND: begin
            ALUControlOut = 3;
            end
            OR: begin
            ALUControlOut = 4;
            end
            XOR: begin
            ALUControlOut = 5;
            end
            SL: begin
            ALUControlOut = 6;
            end
            SR: begin
            ALUControlOut = 7;
            end
        endcase //end instruction decoder case
    end
    
    I: begin //Immediate math
            case (Func4) //Intruction decoder
                ADDI: begin
                ALUControlOut = 8;
                end
                ANDI: begin
                ALUControlOut = 9;
                end
                ORI: begin
                ALUControlOut = 10;
                end
                XORI: begin
                ALUControlOut = 11;
                end
                SLI: begin
                ALUControlOut = 12;
                end
                SRI: begin
                ALUControlOut = 13;
                end
            endcase //end instruction decoder case
        end
        
        LOAD: begin //Load Word
              ALUControlOut = 14;
              end         
        STORE: begin //Load Word
               ALUControlOut = 15;
               end
               
    BRANCH: begin //Branch Instructions
        case(Func4) //decoder case
            BEQ: begin
            ALUControlOut = 16;
            end
            BGT: begin
            ALUControlOut = 17;
            end
            BGE: begin
            ALUControlOut = 18;
            end
            BLT: begin
            ALUControlOut = 19;
            end
        endcase//end instruction decoder case
            end
            
     JALR: begin
        ALUControlOut = 20;
        end       
   default:  ALUControlOut = 0; //default case sets output to 0               
endcase //endcase for ALUOperation case

end

endmodule