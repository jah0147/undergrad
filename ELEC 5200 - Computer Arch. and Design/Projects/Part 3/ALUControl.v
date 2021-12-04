module ALUControl( //tells ALU what operation to perform
input ALUOp,
input [8:6] InstructionMemory,
output reg [4:0] control
);

parameter //Arithmatic
          A = 0, //Arithmatic instructions
          ADD = 4'b0000,
          SUB = 4'b0001,
          AND = 4'b0010,
          OR = 4'b0011,
          XOR = 4'b0100,
          SL = 4'b0101,
          SR = 4'b0110,
          //Immidiate Arithmatic
          I = 1,
          ADDI = 4'b0000,
          ANDI = 4'b0001,
          ORI = 4'b0010,
          XORI = 4'b0011,
          SLI = 4'b0100,
          SRI = 4'b0101,
          //Load Instruction
          LOAD = 3,//only 1 instruction
          //Store Instruction
          STORE = 4,//only 1 instruction
          //Branch
          BRANCH = 6,
          BEQ = 4'b0000,
          BGT = 4'b0001,
          BGE = 4'b0010,
          BLT = 4'b0011,
          //Jump and Link Reg
          JALR  = 7; //only 1 instruction

always @ (ALUOp)
begin
control = 0; //sets control to zero at start so no instructions are performed
case (ALUOp)

    A: begin //arithmatic
        case (InstructionMemory) //Intruction decoder
            ADD: begin
            control = 1;
            end
            SUB: begin
            control = 2;
            end
            AND: begin
            control = 3;
            end
            OR: begin
            control = 4;
            end
            XOR: begin
            control = 5;
            end
            SL: begin
            control = 6;
            end
            SR: begin
            control = 7;
            end
        endcase //end instruction decoder case
    end
    
    I: begin //Immediate math
            case (InstructionMemory) //Intruction decoder
                ADDI: begin
                control = 8;
                end
                ANDI: begin
                control = 9;
                end
                ORI: begin
                control = 10;
                end
                XORI: begin
                control = 11;
                end
                SLI: begin
                control = 12;
                end
                SRI: begin
                control = 13;
                end
            endcase //end instruction decoder case
        end
        
        LOAD: begin //Load Word
              control = 14;
              end         
        STORE: begin //Load Word
               control = 15;
               end
               
    BRANCH: begin //Branch Instructions
        case(InstructionMemory) //decoder case
            BEQ: begin
            control = 16;
            end
            BGT: begin
            control = 17;
            end
            BGE: begin
            control = 18;
            end
            BLT: begin
            control = 19;
            end
        endcase//end instruction decoder case
            end
            
     JALR: begin
        control = 20;
        end       
                       
endcase //endcase for ALUOperation case

end

endmodule