module ALU (
//temp input/output of reg for testing
input [1:0] r1,
input [1:0] r2,
output reg [3:0] rd,

input regFile,
input mux2, //mux for regFile/SignExtended
input ALUControl,
output reg data,
output reg branch_gate //compair output for branches
);

//wire r1;
//wire r2;
wire i = mux2; //immidiate (sign extended will handle immidiate field from opcode)
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
          

always @(ALUControl) //ALUControl will output a number from 0-20 so the ALU will know what operations to perfrom
begin
//setting ALU outputs to 0 at the begining
data = 0;
branch_gate = 0;

case (ALUControl)
    //Arithmatic
    ADD: begin
    rd = r1+r2;
    end
    SUB: begin
    rd = r1-r2;
    end
    AND: begin
    rd = r1&r2;
    end
    OR: begin
    rd = r1 | r2;
    end
    XOR: begin
    rd = r1^r2;
    end
    SL: begin
    rd = 1<<r1;
    end
    SR: begin
    rd = 1>>r1;
    end
    //Immediate Arithmatic
    ADDI: begin
    rd = r1+i;
    end
    ANDI: begin
    rd = r1&i;
    end
    ORI: begin
    rd = r1 | i;
    end
    XORI: begin
    rd = r1^i;
    end
    SLI: begin
    rd = 1<<i;
    end
    SRI: begin
    rd = 1>>i;
    end 
    //Load/Store Word
    LOAD: begin
    rd = r1+i;
    end
    STORE: begin
    //finish later
    end
    //Branch
    BEQ: begin
        if (r1 == r2) begin
        branch_gate = 1; //allowing a branch because terms are met
        end
        else begin
        branch_gate = 0; //terms not met, not allowing branch
        end
    end
    BGT: begin
        if (r1 > r2) begin
        branch_gate = 1; //allowing a branch because terms are met
        end
        else begin
        branch_gate = 0; //terms not met, not allowing branch
        end
    end
    BGE: begin
        if (r1 >= r2) begin
        branch_gate = 1; //allowing a branch because terms are met
        end
        else begin
        branch_gate = 0; //terms not met, not allowing branch
        end
    end
    BLT: begin
        if (r1 > r2) begin
        branch_gate = 1; //allowing a branch because terms are met
        end
        else begin
        branch_gate = 0; //terms not met, not allowing branch
        end
    end
    //Jump and Link Register
    JALR: begin
    //finish
    end           
endcase

end
endmodule