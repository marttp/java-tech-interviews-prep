# AI Fundamentals (พื้นฐาน AI ที่ควรรู้)

## 1. Artificial Intelligence (AI)

AI คือการสร้างระบบคอมพิวเตอร์ที่สามารถทำงานที่ปกติต้องใช้ความฉลาดของมนุษย์ เช่น การเข้าใจภาษา การจดจำภาพ และการตัดสินใจ

**ประเภทของ AI:**

- **Narrow AI (Weak AI)**: ทำได้เฉพาะงานที่ถูก design มาเท่านั้น เช่น ระบบแนะนำสินค้า, chatbot (ปัจจุบันใช้กันทั่วไป)
- **General AI (AGI)**: สามารถทำงานได้ทุกอย่างเหมือนมนุษย์ (ยังเป็นเป้าหมายในอนาคต)
- **Super AI (ASI - Artificial Superintelligence)**: เก่งกว่ามนุษย์ในทุกด้าน (เป็นแนวคิดเชิงทฤษฎี)

## 2. Machine Learning (ML)

ML คือสาขาย่อยของ AI ที่ให้ระบบเรียนรู้จากข้อมูลโดยไม่ต้องเขียนกฎตายตัว

**ประเภทของการเรียนรู้:**

- **Supervised Learning**: เรียนรู้จากข้อมูลที่มี label แล้ว เช่น การจำแนกอีเมลขยะ
- **Unsupervised Learning**: หาโครงสร้างจากข้อมูลที่ไม่มี label เช่น การจัดกลุ่มลูกค้า (Clustering)
- **Reinforcement Learning**: เรียนรู้จากการลองผิดลองถูกและได้รับ reward เช่น การเล่นเกม

## 3. Deep Learning (DL)

DL คือ ML ที่ใช้ Neural Network หลายชั้น (layers) ในการเรียนรู้ feature จากข้อมูลดิบโดยอัตโนมัติ

- **Neural Network**: จำลองการทำงานของสมองมนุษย์ผ่านโหนดที่เชื่อมต่อกัน
- **CNN (Convolutional Neural Network)**: เก่งด้านการประมวลผลภาพ
- **RNN/LSTM**: เก่งด้านข้อมูลที่มีลำดับ เช่น ข้อความ, เสียง
- **Transformer**: สถาปัตยกรรมที่เป็นพื้นฐานของ LLM สมัยใหม่

## 4. Large Language Models (LLM)

LLM คือโมเดล Deep Learning ขนาดใหญ่ที่ถูก train ด้วยข้อมูลข้อความจำนวนมหาศาล สามารถเข้าใจและสร้างข้อความได้อย่างเป็นธรรมชาติ

**แนวคิดสำคัญ:**

- **Token**: หน่วยข้อมูลที่เล็กที่สุดที่ LLM ประมวลผล (ประมาณ 1 คำหรือส่วนของคำ)
- **Context Window**: จำนวน token สูงสุดที่โมเดลสามารถจำได้ในการสนทนาครั้งหนึ่ง
- **Temperature**: ค่าที่ควบคุมความ "สร้างสรรค์" ของคำตอบ (ต่ำ = แน่นอน, สูง = หลากหลาย)
- **Inference**: กระบวนการที่โมเดลสร้างคำตอบจาก input ที่ได้รับ

**ตัวอย่าง LLM:** GPT-4, Claude, Gemini, LLaMA

## 5. AI Agent

AI Agent คือระบบที่ใช้ LLM เป็น "สมอง" ในการวางแผนและตัดสินใจ โดยสามารถใช้ Tools และดำเนินการหลายขั้นตอนเพื่อบรรลุเป้าหมาย

```
User Goal
    │
    ▼
[ LLM (Brain) ] ──► Plan steps
    │
    ▼
[ Tools / Actions ] ──► Execute
    │
    ▼
[ Observe result ] ──► Loop until done
```

**องค์ประกอบหลัก 4 ส่วน:**

- **LLM Core**: สมองของ Agent — รับ input, ตัดสินใจว่าต้องทำอะไร
- **Planning**: กำหนดขั้นตอนในการบรรลุเป้าหมาย เช่น ReAct (Reason + Act), Plan-Execute, Hierarchical Planning
- **Memory**: เก็บ context ข้ามขั้นตอน — Short-term (in-context), Long-term (vector DB หรือ knowledge graph)
- **Tools**: เชื่อมต่อ Agent กับระบบภายนอก เช่น API, database, web search

## 6. Prompt Engineering

Prompt Engineering คือการออกแบบ input ที่ส่งให้ LLM เพื่อให้ได้ผลลัพธ์ที่ต้องการ

**เทคนิคหลัก:**

- **Zero-shot**: ถามตรง ๆ โดยไม่มีตัวอย่าง
- **Few-shot**: ให้ตัวอย่างก่อนถามเพื่อช่วยโมเดลเข้าใจรูปแบบที่ต้องการ
- **Chain-of-Thought (CoT)**: บอกให้โมเดล "คิดทีละขั้น" เพื่อแก้ปัญหาที่ซับซ้อน
- **System Prompt**: กำหนด persona, tone, หรือข้อจำกัดของโมเดล

## 7. Context Engineering

Context Engineering คือการออกแบบและจัดการ context ที่ส่งให้ LLM อย่างมีกลยุทธ์ — ครอบคลุมกว่า Prompt Engineering เพราะดูแลทั้ง pipeline

> Prompt Engineering คือสิ่งที่คุณพิมพ์ใน context window — Context Engineering คือการออกแบบว่าอะไรควรเติมเต็ม window นั้น
> Prompt Engineering เป็น **subset** ของ Context Engineering

**สิ่งที่ต้องจัดการใน context:**

- **What to include**: ข้อมูลที่เกี่ยวข้อง, ประวัติการสนทนา, ผลลัพธ์จาก tools
- **What to exclude**: ข้อมูลที่ไม่จำเป็นที่เปลืองพื้นที่ใน context window
- **How to structure**: จัดลำดับความสำคัญของข้อมูลให้โมเดลใช้ได้ดีที่สุด
- **When to retrieve**: ใช้ RAG หรือ memory เพื่อดึงข้อมูลเข้า context แบบ dynamic

## 8. RAG (Retrieval-Augmented Generation)

RAG คือสถาปัตยกรรมที่เพิ่มความสามารถของ LLM โดยดึงข้อมูลที่เกี่ยวข้องจากแหล่งข้อมูลภายนอกก่อนสร้างคำตอบ ช่วยลด hallucination และแก้ปัญหาข้อมูลหมดอายุ (แต่ไม่ได้กำจัด hallucination ทั้งหมด)

```
Query
  │
  ▼
[ Embed query ] ──► Vector Search ──► [ Relevant Docs ]
                                              │
                                              ▼
                                   [ LLM + Docs as context ] ──► Answer
```

**ขั้นตอนหลัก:**

1. **Indexing**: แปลงเอกสารเป็น vector embeddings แล้วเก็บใน Vector DB
2. **Retrieval**: ค้นหาเอกสารที่ใกล้เคียงกับ query มากที่สุด
3. **Generation**: ส่ง query + เอกสารที่ดึงมา ให้ LLM สร้างคำตอบ

## 9. GraphRAG

GraphRAG คือ RAG ที่ใช้ Knowledge Graph แทน (หรือเสริม) Vector Search พัฒนาโดย Microsoft เพื่อจับความสัมพันธ์ระหว่างข้อมูลได้ดีขึ้น

- เหมาะกับข้อมูลที่มีความสัมพันธ์ซับซ้อน เช่น องค์กร, บุคคล, เหตุการณ์
- ตอบคำถาม multi-hop ได้ดีกว่า RAG ปกติ เช่น "ใครเป็น CEO ของบริษัทที่ลงทุนใน X?"
- Microsoft benchmarks: GraphRAG ได้ 86% accuracy vs RAG ปกติที่ 32% ในคำถามที่ซับซ้อน
- มีต้นทุนในการสร้าง graph สูงกว่า — **LazyGraphRAG** (2025) แก้ปัญหานี้ด้วยต้นทุน indexing เทียบเท่า Vector RAG

## 10. Tools (Function Calling)

Tools คือความสามารถของ LLM ในการเรียกใช้ฟังก์ชันภายนอก เพื่อดึงข้อมูลหรือดำเนินการที่เกินขอบเขตของโมเดลเอง

```
User: "What's the weather in Bangkok?"
  │
  ▼
LLM decides ──► call get_weather(city="Bangkok")
  │
  ▼
Tool returns result ──► LLM formats answer ──► User
```

**ตัวอย่าง Tools ที่ใช้บ่อย:** Web search, Code execution, Database query, API calls

## 11. MCP (Model Context Protocol)

MCP คือ open protocol ที่พัฒนาโดย Anthropic สำหรับเชื่อมต่อ LLM กับแหล่งข้อมูลและ tools ภายนอกในรูปแบบมาตรฐาน

**องค์ประกอบหลักของ MCP:**

- **Resources**: ข้อมูลที่ server เปิดให้ LLM อ่านได้ เช่น ไฟล์, database records
- **Tools**: ฟังก์ชันที่ LLM สามารถเรียกใช้เพื่อดำเนินการ เช่น write file, query DB
- **Prompts**: Template prompt ที่ server กำหนดไว้สำหรับ workflow ทั่วไป

**ประโยชน์:** ลดการเขียน integration ซ้ำ — สร้าง MCP server ครั้งเดียว ใช้ได้กับทุก LLM client ที่รองรับ MCP

> MCP เปิดตัวโดย Anthropic (พ.ย. 2024) และได้รับการ adopt จาก OpenAI และ Google DeepMind จนกลายเป็น industry standard สำหรับการเชื่อมต่อ Agent กับ tools และ data

## 12. Agentic Patterns

Agentic Patterns คือรูปแบบสถาปัตยกรรมสำหรับออกแบบระบบ AI Agent — เลือกให้เหมาะกับความซับซ้อนของงาน ไม่ใช่เลือกตามความซับซ้อนที่ดูดี

### Single-Agent Workflows (Anthropic)

- **Prompt Chaining**: แบ่งงานเป็น steps เรียงต่อกัน output ของ step หนึ่งเป็น input ของ step ถัดไป — เหมาะกับงานที่มีขั้นตอนที่กำหนดได้ล่วงหน้า
- **Routing**: LLM จำแนก input แล้วส่งไปยัง workflow ที่เหมาะสม — เหมาะกับ request ที่หลากหลายประเภท
- **Parallelization**: แบ่งงานออกเป็น subtasks แล้วรันพร้อมกัน หรือรันซ้ำหลายครั้งแล้ว vote ผลลัพธ์
- **Orchestrator-Workers**: LLM กลางแตก task แล้ว delegate ให้ worker LLMs ทำ แล้วรวมผล
- **Evaluator-Optimizer**: LLM หนึ่งสร้างคำตอบ อีกตัวประเมินและให้ feedback วนซ้ำจนได้ผลที่ดี

### Multi-Agent Patterns (Google Cloud)

- **Sequential**: Agent ทำงานต่อกันเป็นสาย output ของ agent หนึ่งเป็น input ของ agent ถัดไป
- **Parallel**: Agent หลายตัวทำงานพร้อมกัน แล้ว synthesize ผลรวม
- **Loop**: วน execute จนกว่าจะตรงตาม termination condition
- **Coordinator**: Agent กลางรับงาน แตก subtask และ dispatch ให้ specialized agents
- **Hierarchical**: Parent agent แตกงานให้ subordinate agents เป็นลำดับชั้น — เหมาะกับงานซับซ้อนมาก
- **Swarm**: Agent หลายตัว communicate กันแบบ all-to-all เพื่อ refine solution ร่วมกัน
- **Human-in-the-Loop**: มี checkpoint ให้มนุษย์ review และ approve ก่อน Agent ดำเนินการต่อ

```
เลือก Pattern อย่างไร:
งานง่าย / ขั้นตอนตายตัว ──► Prompt Chaining / Sequential
input หลากหลาย        ──► Routing
ต้องการความเร็ว        ──► Parallelization
ต้องการคุณภาพสูง       ──► Evaluator-Optimizer / Loop
งานซับซ้อน / หลาย domain ──► Orchestrator-Workers / Hierarchical
ต้องการ oversight      ──► Human-in-the-Loop
```

> อ่านเพิ่มเติมเกี่ยวกับการนำ Agentic Patterns ไปใช้จริงในเชิง engineering culture รวมถึง Multi-Agent Orchestration Principles และแนวคิด Agent-Friendly Codebase ได้ที่: [The Shift from Code to Orchestration: Building AI-Native Engineering Culture](https://portfolio.tpcoder.dev/blog/the-shift-from-code-to-orchestration-building-ai-native-engineering-culture-th/)

## 13. Skills (Agentic Skills)

Skills คือความสามารถเฉพาะด้านที่ถูก encapsulate ไว้ให้ AI Agent เรียกใช้ได้ เปรียบเหมือน reusable modules ของ Agent

- **Predefined Skills**: ความสามารถที่ถูกกำหนดไว้ล่วงหน้า เช่น summarize, translate, search
- **Composable**: Agent สามารถรวม skills หลายอย่างเพื่อทำงานที่ซับซ้อนได้
- **Skill vs Tool**:
  - **Tool** — เชื่อมต่อระบบภายนอก ต้องการ authentication, schema, authorization
  - **Skill** — prompt-based capability pack ที่ encode domain expertise ไว้ ไม่มี schema overhead ใช้ SKILL.md เป็นโครงสร้างหลัก
