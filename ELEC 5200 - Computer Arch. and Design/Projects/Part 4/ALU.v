`timescale 1ns / 1ps
module ALU (
//temp input/output of reg for testing
input [15:0] r1,
input [15:0] mux2,
output reg [15:0] ALUout,
input [4:0] ALUControl,
output reg branchGate //compair output for branches
);
//wire [4:0] ALUControl;

//assign ALUControl = 1; //setting to always add testing

//wire r1;
//wire r2;
wire [15:0] i = mux2; //immidiate (sign extended will handle immidiate field from opcode)
//reg rd;

parameter //Arithmatic
          ADD = 1,
          SUB = 2,
          AND = 3,
          OR = 4,
          XOR = 5,
          SL = 6,
          SR = 7,
          //Immediate Arithmatic
          ADDI = 8,
          ANDI = 9,
          ORI = 10,
          XORI = 11,
          SLI = 12,
          SRI = 13,
          //load/store instrutions
          LOAD = 14,
          STORE = 15,
          //Branch Instructions
          BEQ = 16,
          BGT = 17,
          BGE = 18,
          BLT = 19,
          //JALR Instruction
          JALR = 20;
          

always @(mux2) //ALUControl will output a number from 0-20 so the ALU will know what operations to perfrom
begin

branchGate = 0; //for testing

case (ALUControl)
    //Arithmatic
    ADD: begin
    ALUout = r1+mux2;
    end
    SUB: begin
    ALUout = r1-mux2;
    end
    AND: begin
    ALUout = r1&mux2;
    end
    OR: begin
    ALUout = r1 | mux2;
    end
    XOR: begin
    ALUout = r1^mux2;
    end
    SL: begin
    ALUout = 1<<mux2;
    end
    SR: begin
    ALUout = 1>>mux2;
    end
    //Immediate Arithmatic
    ADDI: begin
    ALUout = r1+mux2;
    end
    ANDI: begin
    ALUout = r1&mux2;
    end
    ORI: begin
    ALUout = r1 | mux2;
    end
    XORI: begin
    ALUout = r1^mux2;
    end
    SLI: begin
    ALUout = r1<<mux2;
    end
    SRI: begin
    ALUout = r1>>mux2;
    end 
    //Load/Store Word
    LOAD: begin
    ALUout = r1+mux2;
    end
    STORE: begin
    ALUout = r1+mux2;
    end
    //Branch
    BEQ: begin
        if (r1 == mux2) begin
        branchGate = 1; //allowing a branch because terms are met
        end
        else begin
        branchGate = 0; //terms not met, not allowing branch
        end
    end
    BGT: begin
        if (r1 > mux2) begin
        branchGate = 1; //allowing a branch because terms are met
        end
        else begin
        branchGate = 0; //terms not met, not allowing branch
        end
    end
    BGE: begin
        if (r1 >= mux2) begin
        branchGate = 1; //allowing a branch because terms are met
        end
        else begin
        branchGate = 0; //terms not met, not allowing branch
        end
    end
    BLT: begin
        if (r1 > mux2) begin
        branchGate = 1; //allowing a branch because terms are met
        end
        else begin
        branchGate = 0; //terms not met, not allowing branch
        end
    end
    //Jump and Link Register
    JALR: begin
    //finish
    end
    default: begin //default case
    ALUout = 0;
    end           
endcase

end
endmodule